from typing import Iterable, List

from award import Award

class Organisation:
    # id is renamed to id_ to avoid conflict with the built-in id() function
    def __init__(self, id_: int, issued_awards: Iterable[Award]):
        self._id: int = id_
        self._issued_awards: List[Award] = list(issued_awards)

    def get_id(self) -> int:
        return self._id

    def get_issued_awards(self) -> Iterable[Award]:
        return self._issued_awards

    def check_one_award_per_game_per_year(self) -> bool:
        # issuedAwards->forAll(a1, a2 | ...)
        for a1 in self._issued_awards:
            for a2 in self._issued_awards:
                # (a1 <> a2 and a1.forGame = a2.forGame)
                premise = (a1 is not a2) and (a1.get_for_game() is a2.get_for_game())

                # implies a1.at.year() <> a2.at.year()
                if premise:
                    conclusion = a1.get_date().year != a2.get_date().year

                    # implies: if premise is true, conclusion must be true
                    if not conclusion:
                        return False
        return True
