def _hire_developers() -> None:
    raise NotImplementedError("Not implemented yet")


def _create_game() -> None:
    raise NotImplementedError("Not implemented yet")


def _assign_developers(*developers: str) -> None:
    raise NotImplementedError("Not implemented yet")


def _release_game() -> None:
    raise NotImplementedError("Not implemented yet")


def _review_game() -> None:
    raise NotImplementedError("Not implemented yet")


def _deserves_award() -> bool:
    raise NotImplementedError("Not implemented yet")


def _create_award() -> None:
    raise NotImplementedError("Not implemented yet")


def main() -> None:
    # Start
    _hire_developers()
    _create_game()
    _assign_developers("Henrik", "Olle", "Jozef")
    _release_game()
    _review_game()
    # Award?
    if _deserves_award():
        # Yes
        _create_award()
    # No

    # End


if __name__ == "__main__":
    main()
