def isPalindrome(x):\n    if x < 0:\n        return False\n    return x == int(str(x)[::-1])
