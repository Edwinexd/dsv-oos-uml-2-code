from datetime import datetime

from organisation import Organisation

class Award:
    def __init__(self, motivation: str, at: datetime, issuer: Organisation, for_game):
        self._motivation = motivation
        self._at = at
        self._issuer = issuer
        self._for_game = for_game
        # In Java this is implied as null by default but in Python
        # we need to set it explicitly so we have an instance variable
        self._edited_at = None

    def get_issuer(self) -> Organisation:
        return self._issuer

    def get_date(self) -> datetime:
        return self._at

    def get_motivation(self) -> str:
        return self._motivation

    def set_motivation(self, motivation: str):
        self._motivation = motivation
        self._set_edited()

    def _set_edited(self):
        self._edited_at = datetime.now()
