def reverseList(head):\n    prev = None\n    while head:\n        next_node = head.next\n        head.next = prev\n        prev = head\n        head = next_node\n    return prev
