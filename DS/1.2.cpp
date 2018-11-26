#include <iostream>
#include <string>
using namespace std;
int main(int argc, char *argv[]) {
	string input;
	while(cin >> input){
		int length = input.size();
		for(int i = 0; i < length ; i++){
			input[i]='m'+'n' - input[i];
		}
		cout << input << endl;
	}
}