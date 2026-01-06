from datetime import datetime
from enum import Enum
from typing import Optional

from organisation import Organisation


class State(Enum):
    DRAFT = 1
    ISSUED = 2
    EDITED = 3
    ARCHIVED = 4


class AwardStateChart:
    # Constructor - corresponds to "new Award()" transition to Draft
    def __init__(self):
        self._current_state: State = State.DRAFT
        self._set_at: datetime = datetime.now()  # entry / set at = now()
        self._motivation: Optional[str] = None
        self._edited: bool = False
        self._organization: Optional[Organisation] = None

    # Transition: Draft -> Issued via submit(Organization)
    def submit(self, organization: Organisation) -> None:
        if self._current_state != State.DRAFT:
            raise IllegalStateError("Can only submit from Draft state")
        self._organization = organization
        self._current_state = State.ISSUED
        self._notify_game_developers()  # do / notify game developers

    # Transition: Issued -> Edited via setMotivation(String)
    # Also: Edited -> Edited (self-loop) via setMotivation(String)
    def set_motivation(self, motivation: str) -> None:
        if self._current_state != State.ISSUED and self._current_state != State.EDITED:
            raise IllegalStateError("Can only set motivation from Issued or Edited state")
        self._motivation = motivation
        self._current_state = State.EDITED
        self._set_edited()  # entry / setEdited()

    # Transition: Issued -> Archived via archive()
    # Transition: Edited -> Archived via archive()
    def archive(self) -> None:
        if self._current_state != State.ISSUED and self._current_state != State.EDITED:
            raise IllegalStateError("Can only archive from Issued or Edited state")
        self._current_state = State.ARCHIVED

    # Internal action for Issued state
    def _notify_game_developers(self) -> None:
        # Implementation for notifying game developers
        print("Notifying game developers about the award...")

    # Entry action for Edited state
    def _set_edited(self) -> None:
        self._edited = True


class IllegalStateError(Exception):
    pass
