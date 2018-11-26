#include <iostream>

using namespace std;
int main(int argc, char *argv[]) {
	long input;
	int day = 0;
	int hour = 0;
	int minute = 0;
	int second = 0;
	while(cin >> input){
		//
		day = input / 86400;
		hour = input % 86400 /3600;
		minute = input % 86400 % 3600 / 60;
		second = input % 86400 % 3600 % 60;
		//
		cout << day << ":" << hour << ":" << minute << ":" << second << endl;
	}
	return 0;
}