from typing import Iterable

from developer import Developer


class Game:
    def __init__(self, title: str, description: str, developed_by: Iterable[Developer]):
        self._title = title
        self._description = description
        self._developed_by = [developer for developer in developed_by]
        if len(self._developed_by) == 0:
            raise ValueError("A game must have at least one developer")
        
    def get_title(self) -> str:
        return self._title
    
    def get_description(self) -> str:
        return self._description
    
    def get_developers(self) -> Iterable[Developer]:
        return self._developed_by
        
