"""/*def isPalindrome(x):
    t = 1
    for i in range(len(s)//2):
        if s[i] != s[-(i+1)]:
            return False
    return True


print(isPalindrome(5))
print(isPalindrome(55))
"""


"""
def maxArea(height):
    foundValues = {}
    h = tuple(height)
    return recFunc(h,foundValues)

def recFunc(height,s):
    if height in s:
        return s[height]
    else:

        if len(height) == 2:
            return min(height[0],height[1])
        moveLast = recFunc(height[0:len(height)-1],s)
        moveFirst = recFunc(height[1:len(height)],s)
        curArea = (len(height)-1)*min(height[len(height)-1],height[0])
        ret = max(moveLast,moveFirst,curArea)
        s[height] = ret
        return ret

print(maxArea([1,2,3,4,5,1]))"""

"""
def intToRoman(num):
    retString = ""
    while num > 0:
        if num >= 1000:
            if num >= 400:
                retString += "CM"
            else:
                retString += num//1000 * "M"
            num = num % 1000
        if num >= 500:
            retString += num//500 * "D"
            num = num % 500
        if num >= 100:
            if num >= 400:
                retString += "CD"
            else:
                retString += num//100 * "C"
            num = num % 100
        if num >= 50:
            retString += num//50 * "L"
            num = num % 50
        if num >= 10:
            retString += num//10 * "X"
            num = num % 10
        if num >= 5:
            retString += num//5 * "V"
            num = num % 5
        if num >= 1:
            retString += num * "I"
            num = 0
        
    return retString

print(intToRoman(19))"""

"""
def threeSum(nums):
    nums.sort()
    retList = set()
    for i in range(len(nums)):

        f = i+1
        l = len(nums)-1
        if f >= l:
            return retList
        while f<=l:
            sum = nums[f]+nums[l]+nums[i]
            if  f==i:
                f+=1
            elif i == l:
                l-=1
            elif sum == 0:
                retList.add((nums[f],nums[l],nums[i]))
                l-=1
                f+=1
            elif sum > 0:
                l-=1
            elif sum < 0:
                f+=1

print(threeSum([-1,0,1,2,-1,-4]))
"""

def jump(nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i = 0
        retList=[]
        while i != len(nums)-1:
            i = findBiggestRange(nums,i,retList)
        return retList
                
def findBiggestRange(nums,curIndex,retList):
    biggestRangeIndex = 0
    biggestRange = 0
    for i in range(nums[curIndex]):
        curRange = nums[i+curIndex] + curIndex
        if curRange >= len(nums)-1:
            biggestRangeIndex = i+curIndex+1
            break
        if curRange > biggestRange:
            biggestRange = curRange
            biggestRangeIndex = i+curIndex+1
    retList.append(i+biggestRangeIndex)
    return biggestRangeIndex

print(jump([1,2,3,1]))