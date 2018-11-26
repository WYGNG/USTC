#include <iostream>
#include <string>
#include <cmath>

using namespace std;
bool isAlpha(char _in){
	if((_in>='a'&&_in<='z')||(_in>='A'&&_in<='Z')) return true;
	else return false;
	
}

int main(int argc, char *argv[]) {
	string s;
	
	while(getline(cin, s)){
		int state = 0;
		int n = 0;
		int tail = 0;
		for(int i = 0; i < s.size();){
			if(!isAlpha(s[i])) {
				i++;
				continue;	
			}
			else{
				tail = i;
				while(isAlpha(s[tail])){
					tail++;
				}
				n++;
				i=tail;
			}
			
		}
		cout << n << endl;

	}
	
}