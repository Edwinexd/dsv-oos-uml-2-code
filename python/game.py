from typing import Iterable, List

from developer import Developer
from academic_diploma import AcademicDiploma
from award import ALL_AWARDS


class Game:
    def __init__(self, title: str, description: str, developed_by: Iterable[Developer]):
        self._title: str = title
        self._description: str = description
        self._developed_by: List[Developer] = list(developed_by)
        if len(self._developed_by) == 0:
            raise ValueError("A game must have at least one developer")

    def get_title(self) -> str:
        return self._title

    def get_description(self) -> str:
        return self._description

    def get_developers(self) -> Iterable[Developer]:
        return self._developed_by

    def check_award_winning_requires_qualified_team(self) -> bool:
        # Award.allInstances()->exists(a | a.forGame = self)
        has_award = any(a.get_for_game() is self for a in ALL_AWARDS)

        # implies: if no award, constraint is satisfied
        if not has_award:
            return True

        # developedBy->forAll(d | d.earned->includes(...) or ...)
        return all(
            AcademicDiploma.MASTER in d.get_earned() or
            AcademicDiploma.LICENTIATE in d.get_earned() or
            AcademicDiploma.DOCTORATE in d.get_earned()
            for d in self._developed_by
        )
