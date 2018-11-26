#include <iostream>
#include <string>
#include <cmath>
int temp[2][12]={31,29,31,30,31,30,31,31,30,31,30,31,
				31,28,31,30,31,30,31,31,30,31,30,31	
};			

using namespace std;

int main(int argc, char *argv[]) {
	string s;
	int state = 0;
	while(getline(cin, s)){
		int year = 0;
			int month = 0;
			int day = 0;
			int i = 0;
			for(; s[i] != ' ';i++){
				year += (s[i]-'0')*pow(10,3-i);
			}//年
			i++;
			if(s[i+1]==' '){
				month = s[i]-'0';
				i+=2;
			}
			else if(s[i+1]!=' '){
				month = (s[i]-'0')*10 + s[i+1]-'0';
				i+=3;
			}//月
			
			//当时思路混乱了
			if(s[i]<='9'&&s[i]>='0'&&s[i+1]<='9'&&s[i+1]>='0'){
				day = (s[i]-'0')*10+s[i+1]-'0';
			}
			else{
				day = s[i]-'0';
			}
			
			//日
			
			if(year%400 ==0 || (year%4==0&&year%100!=0)){
				state = 0;	
			}
			else{
				state = 1;
			}
			//cout << year << ':' << month << ":" << day <<endl;
			//cout << s << endl;
			//cout << state << endl;
			if(day<=temp[state][month-1]){
				cout << "正确" << endl;
			}
			else{
				cout << "不正确" << endl;
			}

	}

	
}