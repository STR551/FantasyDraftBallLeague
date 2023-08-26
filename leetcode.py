def isPalindrome(x):
    t = 1
    for i in range(len(s)//2):
        if s[i] != s[-(i+1)]:
            return False
    return True


print(isPalindrome(5))
print(isPalindrome(55))