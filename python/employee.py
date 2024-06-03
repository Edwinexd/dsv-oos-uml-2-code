class Employee:
    def __init__(self, name: str):
        if not Employee.is_valid_name(name):
            raise ValueError(f"Invalid name: {name}")
        self._name = name

    @staticmethod
    def is_valid_name(name: str) -> bool:
        """
        Check if the name is valid.
        A valid name should have at least 2 words separated by a space.
        """
        return len(name) > 0 and len(name.split()) > 1

    def get_name(self) -> str:
        return self._name
