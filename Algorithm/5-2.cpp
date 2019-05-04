#include <iostream>
using namespace std;

class node{
	public:
		int value;
		node * next;
	
	public:	
		node(int value = 0,node * next = NULL){
			this->value = value;
			this->next = next;
		}
};
class Solution {
public:
	node* oddEvenList(node* head) {
		if (!head || !head->next) return head;
		node *pre = head, *cur = head->next;
		while (cur && cur->next) {
			node *tmp = pre->next;
			pre->next = cur->next;
			cur->next = cur->next->next;
			pre->next->next = tmp;
			cur = cur->next;
			pre = pre->next;
		}
		return head;
	}
};

int main(int argc, char *argv[]) {
	int m = 0;
	while(cin >> m){
		/*建立链表1*/
		node * head_first = new node();
		node * tail_first = head_first;
		for(int i = 0 ; i < m ; i ++){
			node * p = new node();
			int temp;
			cin >> temp;
			p->value = temp;	
			tail_first->next = p;
			tail_first = p;
		}
		/*输出链表1和2*/
		node * head_1 = head_first->next;
		while(head_1){
			cout << head_1->value << " ";
			head_1 = head_1->next;
		}
		cout << endl;
		
		
		/*输出新链表*/
		Solution * solution = new Solution();
		node * p = solution->oddEvenList(head_first->next);
		
		
		while(p){
			cout << p->value << " ";
			p = p->next;
		}
		cout << endl;
		
	}
}