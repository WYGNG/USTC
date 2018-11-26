#include <iostream>

using namespace std;
int main(int argc, char *argv[]) {
	string J;
	string S;
	//一般思路
	cout << "连续输入两个字符串并确定" << endl;
	while(cin >> J >> S){
		int sum = 0;
			for(int i = 0; i < J.size(); i++){
				for(int j = 0; j < S.size(); j++){
					if(S[j]==J[i]) sum++;
				}
			}
			cout << sum << endl;
	}
	return 0;
	
}