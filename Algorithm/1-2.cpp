#include <iostream>
#include <vector>
using namespace std;
vector<vector<int> > res;
// 求解C(n,k), 当前已经找到的组合存储在path中, 需要从index开始搜索新的元素
void findPath(int n,int k, int index, vector<int> path){
	if(path.size() == k)   //停止条件：当找到的路径长度等于k，表示已经到底部，开始回溯
	{
		res.push_back(path);
		return;
	}
	for(int i=index;i<=n;i++)  //递归，其中i是从index开始，表示可用区间为[index,n]
	{
		path.push_back(i);
		findPath(n,k,i+1,path);
		path.pop_back();      //状态回溯，回溯到path保存路径的上一层，继续进行遍历
	}
}
vector<vector<int> > combine(int n, int k) {
	if(n<=0)
	{
		return res;
	}

	vector<int> path;
	findPath(n,k,1,path);
	return res;
}



int main(int argc, char *argv[]) {
	int n = 0;
	int k = 0;
	while(cin >> n >> k){
		combine(n,k);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res[i].size(); j++){
				cout << res[i][j] << ' ';
			}
			
			cout << endl;
		}
		
		
	}
}

//https://blog.csdn.net/wys2011101169/article/details/72887512


