#include <iostream>
#include <string>

using namespace std;
string temp = "debug";

int main(int argc, char *argv[]) {
	string s;
	while(getline(cin, s)){
		int n = 0;
		bool state = false;
		for(int i = 0,j = 0; i < temp.size()&&j < s.size();){
			
			if(temp[i]==s[j]){
				i++;j++;
				n++;
				if(i == temp.size()){
					cout << "存在" << endl;
					state = true;
					continue;
				}
				
			}
			else{
				i = 0;
				j -= n - 1;
				n = 0;
			}

			
				
		}
		if(state == false){
			cout << "不存在" << endl;
		}
		
	}
}