from typing import Iterable, List

from award import Award

class Organisation:
    # id is renamed to id_ to avoid conflict with the built-in id() function
    def __init__(self, id_: int, issued_awards: Iterable[Award]):
        self._id: int = id_
        self._issued_awards: List[Award] = [award for award in issued_awards]

    def get_id(self) -> int:
        return self._id

    def get_issued_awards(self) -> Iterable[Award]:
        return self._issued_awards
