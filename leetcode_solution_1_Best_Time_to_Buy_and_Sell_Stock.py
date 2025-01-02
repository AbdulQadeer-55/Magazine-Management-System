# Solution for Best Time to Buy and Sell Stock

# Problem:
# Say you have an array for which the ith element is the price of a given stock on day i.
# 
# If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
#
# Note that you cannot sell a stock before you buy one.
# 
# Example 1:
#
# Input: [7,1,5,3,6,4]
# Output: 5
# Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
#              Not 7-1 = 6, as selling price needs to be larger than buying price.
# Example 2:
#
# Input: [7,6,4,3,1]
# Output: 0
# Explanation: In this case, no transaction is done, i.e. max profit = 0.
#
# Constraints:
#
# 1 <= prices.length <= 105
# 0 <= prices[i] <= 105
#
# Solution:
# The problem is to find the maximum difference between two elements in the array such that the larger element appears after the smaller element.
# The approach is to iterate through the array and keep track of the minimum element found so far and the maximum difference found so far.
# The maximum difference is updated when a new minimum element is found.
# The time complexity is O(n) where n is the number of elements in the array.
# The space complexity is O(1) as we are using only a constant amount of space.
# The code is as follows:   

