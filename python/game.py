from typing import Iterable, List

from developer import Developer


class Game:
    def __init__(self, title: str, description: str, developed_by: Iterable[Developer]):
        self._title: str = title
        self._description: str = description
        self._developed_by: List[Developer] = [developer for developer in developed_by]
        if len(self._developed_by) == 0:
            raise ValueError("A game must have at least one developer")
        
    def get_title(self) -> str:
        return self._title
    
    def get_description(self) -> str:
        return self._description
    
    def get_developers(self) -> Iterable[Developer]:
        return self._developed_by
        
