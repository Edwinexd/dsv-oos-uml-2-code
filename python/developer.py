from employee import Employee
from academic_diploma import AcademicDiploma

from typing import Iterable

class Developer(Employee):
    def __init__(self, name: str):
        super().__init__(name)
        self._has: Iterable[AcademicDiploma] = []

