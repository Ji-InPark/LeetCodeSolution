class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode d(0);
        ListNode *result = &d;
        ListNode *temp = result;
        int count1 = 0, count2 = 0;
        int arr[101] = {0};
        bool plusOne = false;
        while (l1)
        {
            arr[count1++] = l1->val;
            l1 = l1->next;
        }
        while (l2)
        {
            arr[count2] += l2->val;
            if (plusOne)
            {
                arr[count2]++;
            }
            plusOne = false;
            if (arr[count2] >= 10)
            {
                plusOne = true;
                arr[count2] -= 10;
            }
            count2++;
            l2 = l2->next;
        }
        if (plusOne)
        {
            arr[count2]++;
        }
        count2 = max(count1, count2);
        for (int i = 0; i < count2; i++)
        {
            if (arr[i] >= 10)
            {
                plusOne = true;
                arr[i] -= 10;
                arr[i + 1]++;
            }
            temp->next = new ListNode(arr[i]);
            temp = temp->next;
        }
        
        if(arr[count2]) 
        {
            temp->next = new ListNode(arr[count2]);
            temp = temp->next;
        }
        
        return result->next;
    }
};