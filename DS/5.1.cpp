#include <iostream>

using namespace std;

bool isprime(int x){
	int sum = 0;
	for(int i = 1; i <= x;i++){
		if(x%i == 0) sum ++; 
	}
	if(sum == 2) return 1;
	else return 0;
}
int main(int argc, char *argv[]) {
	int m = 0;
		while(cin >> m){
			
			for(int i = 1; i <= m;){
				if(isprime(i)&&isprime(i+2)&&i+2<=m){
					cout << i << ' ' << i + 2 << ' ';
					i++;
					cout << endl;
				}
				else{
					i++;
				}						
			}
	
		}
			
}