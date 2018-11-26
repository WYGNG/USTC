#include <iostream>
using namespace std;
int hashFunc(int _in){
	return _in%11;
}
class node{
	public:
		node(int _val=0){
			val = _val;
			next = NULL;
		}
	public:
		int val;
		node * next;
	
	
		
};
int main(int argc, char *argv[]) {
	int input[12] = {19,14,23,1,68,20,84,27,56,11,10,79};
	node *res[12] ;
	for(int i = 0; i < 12; i++){
		res[i] = new node();
	}
	for(int i = 0; i < 12; i++){
		int j = hashFunc(input[i]);//得到哈希值
		node * q = res[j];//当前节点游标
		
		node * p = new node(input[i]);//新建节点
		
		while(q->next!=NULL){
			q = q->next;
		}//找到尾巴
		q->next = p;//链接
		res[j]->val++;//计数++
	}
	for(int i = 0; i < 12; i++){
		cout << '[' << i << ':' <<res[i]->val << ']';
		node * q = res[i]->next;
		while(q!=NULL){
			cout << q->val;
			q = q->next;
			if(q) cout << "->";
		}
		cout << endl;
	}
	
	
}