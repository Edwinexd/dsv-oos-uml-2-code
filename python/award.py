from __future__ import annotations
from datetime import datetime
from typing import Optional, List, TYPE_CHECKING

if TYPE_CHECKING:
    from organisation import Organisation
    from game import Game

ALL_AWARDS: List[Award] = []

class Award:
    def __init__(self, motivation: str, at: datetime, issuer: Organisation, for_game: Game):
        self._motivation: str = motivation
        self._at: datetime = at
        self._issuer: Organisation = issuer
        self._for_game: Game = for_game
        # In Java this is implied as null by default but in Python
        # we need to set it explicitly so we have an instance variable
        self._edited_at: Optional[datetime] = None
        ALL_AWARDS.append(self)

    def get_issuer(self) -> Organisation:
        return self._issuer

    def get_date(self) -> datetime:
        return self._at

    def get_motivation(self) -> str:
        return self._motivation

    def get_for_game(self) -> Game:
        return self._for_game

    def set_motivation(self, motivation: str):
        self._motivation = motivation
        self._set_edited()

    def _set_edited(self):
        self._edited_at = datetime.now()
