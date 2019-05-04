
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


int main(int argc, char *argv[]) {
	int m = 0;
	while(cin >> m){
		/*建立链表*/
		node * head_first = new node(m);
		node * tail_first = head_first;
		for(int i = 0 ; i < m ; i ++){
			node * p = new node();
			int temp;
			cin >> temp;
			p->value = temp;	
			tail_first->next = p;
			tail_first = p;
		}
		/*输出链表*/
		node * head_1 = head_first->next;
		while(head_1){
			cout << head_1->value << " ";
			head_1 = head_1->next;
		}
		cout << endl;
		int mid = m/2+1;
		node * p = head_first;
		for(int i = 0 ; i < mid ; i ++){
			p = p->next;
		}
		cout << p->value << endl;
	}
}