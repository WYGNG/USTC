#include <iostream>

using namespace std;

int factor(int a,int b){
	int sum = 0;
	if(a==1) return 1;
	for(int i = b; i <= a; i++){
		if(a%i == 0){
			sum+=factor(a/i, i);
		}
	}
	return sum;
}
int main(int argc, char *argv[]) {
	int input = 0;
	while(cin >> input){
		cout << factor(input	, 2) << endl;;
		
	}
}