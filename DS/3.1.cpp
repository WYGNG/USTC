#include <iostream>

using namespace std;
int main(int argc, char *argv[]) {
	int temp[10] = {0,0,0,0,0, 0,0,0,0,1};//表示剩余的
	for(int i = 9; i>=1; i --){
		temp[i-1] = (temp[i]+1)*2;
	}
	cout << temp[0] << endl;
}