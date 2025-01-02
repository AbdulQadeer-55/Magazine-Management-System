def twoSum(nums, target):\n    for i in range(len(nums)):\n        for j in range(i+1, len(nums)):\n            if nums[i] + nums[j] == target:\n                return [i, j]
def reverseList(head):\n    prev = None\n    while head:\n        next_node = head.next\n        head.next = prev\n        prev = head\n        head = next_node\n    return prev
def lengthOfLongestSubstring(s):\n    chars = {}\n    left = 0\n    max_len = 0\n    for right in range(len(s)):\n        if s[right] in chars and chars[s[right]] >= left:\n            left = chars[s[right]] + 1\n        chars[s[right]] = right\n        max_len = max(max_len, right - left + 1)\n    return max_len
def addTwoNumbers(l1, l2):\n    carry = 0\n    result = ListNode(0)\n    current = result\n    while l1 or l2 or carry:\n        val = carry\n        if l1:\n            val += l1.val\n            l1 = l1.next\n        if l2:\n            val += l2.val\n            l2 = l2.next\n        carry, val = divmod(val, 10)\n        current.next = ListNode(val)\n        current = current.next\n    return result.next
def merge(intervals):\n    intervals.sort(key=lambda x: x[0])\n    merged = []\n    for interval in intervals:\n        if not merged or merged[-1][1] < interval[0]:\n            merged.append(interval)\n        else:\n            merged[-1][1] = max(merged[-1][1], interval[1])\n    return merged
def isValid(s):\n    stack = []\n    mapping = {')': '(', '}': '{', ']': '['}\n    for char in s:\n        if char in mapping:\n            top_element = stack.pop() if stack else '#'\n            if mapping[char] != top_element:\n                return False\n        else:\n            stack.append(char)\n    return not stack
def romanToInt(s):\n    roman_map = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}\n    total = 0\n    prev_value = 0\n    for char in reversed(s):\n        current_value = roman_map[char]\n        if current_value < prev_value:\n            total -= current_value\n        else:\n            total += current_value\n        prev_value = current_value\n    return total
def isPalindrome(x):\n    if x < 0:\n        return False\n    return x == int(str(x)[::-1])
def myAtoi(s):\n    s = s.strip()\n    if not s:\n        return 0\n    sign = 1\n    if s[0] == '-':\n        sign = -1\n        s = s[1:]\n    elif s[0] == '+':\n        s = s[1:]\n    result = 0\n    for char in s:\n        if char.isdigit():\n            result = result * 10 + int(char)\n        else:\n            break\n    return sign * result
def maxArea(height):\n    left, right = 0, len(height) - 1\n    max_area = 0\n    while left < right:\n        width = right - left\n        max_area = max(max_area, min(height[left], height[right]) * width)\n        if height[left] < height[right]:\n            left += 1\n        else:\n            right -= 1\n    return max_area
def twoSum(nums, target):\n    for i in range(len(nums)):\n        for j in range(i+1, len(nums)):\n            if nums[i] + nums[j] == target:\n                return [i, j]
def reverseList(head):\n    prev = None\n    while head:\n        next_node = head.next\n        head.next = prev\n        prev = head\n        head = next_node\n    return prev
def lengthOfLongestSubstring(s):\n    chars = {}\n    left = 0\n    max_len = 0\n    for right in range(len(s)):\n        if s[right] in chars and chars[s[right]] >= left:\n            left = chars[s[right]] + 1\n        chars[s[right]] = right\n        max_len = max(max_len, right - left + 1)\n    return max_len
def addTwoNumbers(l1, l2):\n    carry = 0\n    result = ListNode(0)\n    current = result\n    while l1 or l2 or carry:\n        val = carry\n        if l1:\n            val += l1.val\n            l1 = l1.next\n        if l2:\n            val += l2.val\n            l2 = l2.next\n        carry, val = divmod(val, 10)\n        current.next = ListNode(val)\n        current = current.next\n    return result.next
def merge(intervals):\n    intervals.sort(key=lambda x: x[0])\n    merged = []\n    for interval in intervals:\n        if not merged or merged[-1][1] < interval[0]:\n            merged.append(interval)\n        else:\n            merged[-1][1] = max(merged[-1][1], interval[1])\n    return merged
def isValid(s):\n    stack = []\n    mapping = {')': '(', '}': '{', ']': '['}\n    for char in s:\n        if char in mapping:\n            top_element = stack.pop() if stack else '#'\n            if mapping[char] != top_element:\n                return False\n        else:\n            stack.append(char)\n    return not stack
def romanToInt(s):\n    roman_map = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}\n    total = 0\n    prev_value = 0\n    for char in reversed(s):\n        current_value = roman_map[char]\n        if current_value < prev_value:\n            total -= current_value\n        else:\n            total += current_value\n        prev_value = current_value\n    return total
def isPalindrome(x):\n    if x < 0:\n        return False\n    return x == int(str(x)[::-1])
def myAtoi(s):\n    s = s.strip()\n    if not s:\n        return 0\n    sign = 1\n    if s[0] == '-':\n        sign = -1\n        s = s[1:]\n    elif s[0] == '+':\n        s = s[1:]\n    result = 0\n    for char in s:\n        if char.isdigit():\n            result = result * 10 + int(char)\n        else:\n            break\n    return sign * result
def maxArea(height):\n    left, right = 0, len(height) - 1\n    max_area = 0\n    while left < right:\n        width = right - left\n        max_area = max(max_area, min(height[left], height[right]) * width)\n        if height[left] < height[right]:\n            left += 1\n        else:\n            right -= 1\n    return max_area
def twoSum(nums, target):\n    for i in range(len(nums)):\n        for j in range(i+1, len(nums)):\n            if nums[i] + nums[j] == target:\n                return [i, j]
def reverseList(head):\n    prev = None\n    while head:\n        next_node = head.next\n        head.next = prev\n        prev = head\n        head = next_node\n    return prev
def lengthOfLongestSubstring(s):\n    chars = {}\n    left = 0\n    max_len = 0\n    for right in range(len(s)):\n        if s[right] in chars and chars[s[right]] >= left:\n            left = chars[s[right]] + 1\n        chars[s[right]] = right\n        max_len = max(max_len, right - left + 1)\n    return max_len
def addTwoNumbers(l1, l2):\n    carry = 0\n    result = ListNode(0)\n    current = result\n    while l1 or l2 or carry:\n        val = carry\n        if l1:\n            val += l1.val\n            l1 = l1.next\n        if l2:\n            val += l2.val\n            l2 = l2.next\n        carry, val = divmod(val, 10)\n        current.next = ListNode(val)\n        current = current.next\n    return result.next
def merge(intervals):\n    intervals.sort(key=lambda x: x[0])\n    merged = []\n    for interval in intervals:\n        if not merged or merged[-1][1] < interval[0]:\n            merged.append(interval)\n        else:\n            merged[-1][1] = max(merged[-1][1], interval[1])\n    return merged
def isValid(s):\n    stack = []\n    mapping = {')': '(', '}': '{', ']': '['}\n    for char in s:\n        if char in mapping:\n            top_element = stack.pop() if stack else '#'\n            if mapping[char] != top_element:\n                return False\n        else:\n            stack.append(char)\n    return not stack
def romanToInt(s):\n    roman_map = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}\n    total = 0\n    prev_value = 0\n    for char in reversed(s):\n        current_value = roman_map[char]\n        if current_value < prev_value:\n            total -= current_value\n        else:\n            total += current_value\n        prev_value = current_value\n    return total
def isPalindrome(x):\n    if x < 0:\n        return False\n    return x == int(str(x)[::-1])
def myAtoi(s):\n    s = s.strip()\n    if not s:\n        return 0\n    sign = 1\n    if s[0] == '-':\n        sign = -1\n        s = s[1:]\n    elif s[0] == '+':\n        s = s[1:]\n    result = 0\n    for char in s:\n        if char.isdigit():\n            result = result * 10 + int(char)\n        else:\n            break\n    return sign * result
def maxArea(height):\n    left, right = 0, len(height) - 1\n    max_area = 0\n    while left < right:\n        width = right - left\n        max_area = max(max_area, min(height[left], height[right]) * width)\n        if height[left] < height[right]:\n            left += 1\n        else:\n            right -= 1\n    return max_area
