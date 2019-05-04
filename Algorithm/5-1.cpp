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
	bool hasCycle(node *head) {
		if(head == NULL || head->next == NULL) {
			return false;
		}

		node* fast = head;
		node* slow = head;

		while(fast->next != NULL && fast->next->next != NULL) {
			fast = fast->next->next;
			slow = slow->next;
			if(slow == fast) {
				return true;
			}
		}

		return false;
	}
};

int main(int argc, char *argv[]) {
	int m = 0;
	int n = 0;
	while(cin >> m >> n){
		/*建立链表1*/
		node * head_first = new node();
		node * tail_first = head_first;
		node * r = NULL;
		int i = 0;
		for(int i = 0 ; i < m ; i ++){
			node * p = new node();
			int temp;
			cin >> temp;
			p->value = temp;	
			tail_first->next = p;
			tail_first = p;
			i++;
			if(i==m/2){
				r = tail_first;
			}
		}
		tail_first->next = r;
		tail_first = r;
		
		/*建立链表2*/
		node * head_second = new node();
		node * tail_second = head_second;
		for(int i = 0 ; i < n ; i ++){
			node * p = new node();
			int temp;
			cin >> temp;
			p->value = temp;
			tail_second->next = p;
			tail_second = p;
		}
		
		cout << endl;
		Solution * solution = new Solution();
		if(solution->hasCycle(head_first->next))	cout << "True" << endl;
		else 	cout << "False" << endl;
		if(solution->hasCycle(head_second->next))	cout << "True" << endl;
		else 	cout << "False" << endl;
		
	}
}