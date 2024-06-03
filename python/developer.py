from employee import Employee
from academic_diploma import AcademicDiploma

from typing import Iterable, List

class Developer(Employee):
    def __init__(self, name: str, diplomas: Iterable[AcademicDiploma]):
        super().__init__(name)
        self._earned: List[AcademicDiploma] = [diploma for diploma in diplomas]

