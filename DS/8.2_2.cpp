#include <iostream>
using namespace std;
int hashFunc(int _in){
	return _in%11;
}
class node{
	public:
		node(int _val=0, bool _flag=false){
			val = _val;
			flag = _flag; 
			sum = 0;
		}
	public:
		int val;
		bool flag;
		int sum;
				
};

int main(int argc, char *argv[]) {
	int input[12] = {19,14,23,1,68,20,84,27,56,11,10,79};
	node * res[12];
	for(int i = 0; i < 12; i++){
		res[i] = new node();
	}
	for(int i = 0; i < 12; i ++){
		int j = hashFunc(input[i]);
		if(res[j]->flag == false){
			res[j]->val = input[i];
			res[j]->flag = true;
		}
		else{
			while(res[++j%12]->flag == true){
				res[j]->sum ++;
			}
			res[j]->val = input[i];
			res[j]->flag = true;
			
		}
	}
	for(int i = 0; i < 12; i++){
		cout << i << ':' << res[i]->val << ' ' << res[i]->flag << ' ' << res[i]->sum << endl;;
	}
	
	
	
}