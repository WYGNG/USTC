#include <iostream>
#include <string>
using namespace std;
int t[4] = {0};
void swap(int &_a,int &_b){
	int temp = 0;
	temp = _a;
	_a = _b;
	_b = temp;
}
void exchange(void){
	swap(t[0],t[2]);
	swap(t[1],t[3]);
}


int main(int argc, char *argv[]) {

	int input = 0;
	while(cin >> input){
		t[0] = input /1000;
		t[1] = input %1000/100;
		t[2] = input %100/10;
		t[3] = input %10;
		int i = 0;
		while(i<4){
			t[i] = (t[i]+7)%10;
			i++;
		}
		exchange();
		for(int i = 0; i < 4; i++){
			cout << t[i];
		}
		cout << endl;
	}
}


