# 这里是本人学完ac自动机之后的一些总结

```
这里用的是kuangbin的ac自动机的板子。
ac自动机，怎么说呢，其实就是trie树(字典树)加上kmp的算法思路。
```
```
	int createNode(){
        for(int i=0;i<26;++i){
            next[tot][i]=-1;　//初始化next数组
        }
        end[tot++]=0;　//表示模式串的终端节点，用来标记某个模式串
        return tot-1;
    }
    void init(){
        tot=0;
        rt=createNode();
    }
    void insert(char *str){
        int len=strlen(str);
        int cur=rt;　
        for(int i=0;i<len;++i){　//从根节点的下一个节点开始建
            if(next[cur][str[i]-'a']==-1){
                next[cur][str[i]-'a']=createNode();
            }
            cur=next[cur][str[i]-'a'];
        }
        end[cur]++;
    }
```
```
这一段其实就是建立trie树的代码，不懂的话可以学一下。
其实就是用next二维数组来模拟建树。
```
```
接下来就是ac自动机的核心部分，fail指针的构建，
这里的fail函数其实就是类似kmp算法的next函数，如果我们的模式串在Tire
上进行匹配时，与当前节点的关键字不能继续匹配的时候，就应该去当前节点的
fail指针所指向的节点继续进行匹配。
```
```
这里盗用一些别人的配图
```
![这里写图片描述](http://img.blog.csdn.net/20170319133442475?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvVmlzY3U=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
```
例如模式串有,say,she,shr,her.
上图就是根据这些模式串来建立trie树,红圈其实就是上述的end数组，
表示这条路径上到这个节点所组成的字符串是模式串的其中一个。
接下来我们就要根据这个图还有代码来建立fail指针。
```
```
1 void build(){
2        queue<int> que;
3        fail[rt]=rt;
4        for(int i=0;i<26;++i){
5           if(next[rt][i]==-1){ 
6                next[rt][i]=rt; 
7            }else{
8               fail[next[rt][i]]=rt;
9               que.push(next[rt][i]);
10           }
11        }
12        while(!que.empty()){
13            int cur=que.front();
14            que.pop();
15            for(int i=0;i<26;++i){
16                if(next[cur][i]==-1){
17                    next[cur][i]=next[fail[cur]][i];//找不到fail指针跳到指向下一个匹配位置
18                }else{
19                    fail[next[cur][i]]=next[fail[cur]][i];
20                  　que.push(next[cur][i]);
21               }
22          }
23     }
24 }
```
![这里写图片描述](http://img.blog.csdn.net/20170319134117209?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvVmlzY3U=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
```
代码3-5行是处理模式串的第一个字符，第一层的fali指针都是指向root节点的。
如图，按照字典序，h的fail指针指向rt，如图中的虚线1(虚线就是该节点fail指针的指向),
然后把h入队，接着处理s.由于第一层,所以s的fail指针也是指向root节点，如图中的虚线2,
然后把s入队。队列中就有(h,s).
第一层出现到这里就结束的。
接着就出现队列中的节点。首先是h,h的next节点有e,当for循环处理到e这个节点时，
那么就进行19行～20行的操作，找e的fail指针，那我们就返回到第一层寻找有没有
之前有没有出现过e这个节点，发现没有，那么e这个节点的fail指针就指向root节点，
也就是图中的虚线3,然后e入队，这时候处理完h所以的next节点，队列中现在有(s,e),
接着处理队列中的s节点，s的next节点有a,h,a和上面的e是同理的，这里就不说，
记得找到a的fail指针，要把a入队哦。
接着处理h,我们发现上一层(也就是第一层)出现过h这个节点，那么h的fail指针
就指向第一层的h节点，也就是虚线5,
然后h入队，这时候队列中有(e,a,h),其实接下来的步骤和上面是一样的，依照
循环，最后找出所有节点的fail指针，
那么ac自动机最核心的部分讲完了。
```
```
接着就是模式串匹配了。
模式串：say,she,shr,her
主串：yasherhs
```
```
 int query(char *buf){
        int len=strlen(buf);
        int cur=root;
        int res=0;
        for(int i=0;i<len;i++){
            cur=next[cur][buf[i]-'a'];
            int temp=cur;
            while(temp!=root){
                res+=end[temp];
                end[temp]=0;
                temp=fail[temp];
            }
        }
        return res;
}
```
```
首先呢，y和a在trie树没有对应的路径，不会执行while循环，所以直接跳过。
接着就s,h,e这三个了，由于s,sh这都不是模式串，所以res还是0，
当到e这个节点的时候，这时候cur是在she这条路径的e节点上，恰好she是一个模式串，
那么res+=1,然后把end[temp]变成0是为了防止后面会出现同样的模式串。
接着我们就跳到e的fail指针所指向的节点,我们会发现，当前节点也是模式串
的一个，即he,那么我们已经找到两个模式串she,he了。
接着到r了，这时候的r的节点是在her这条路径上的，刚好也就是
模式串的其中一个，那么res就+1.可能有小伙伴就会疑问了，你之前的路径不是she
上的吗，怎么会跑到her这条路径上呢。
其实这个在建立fail指针上就有了。
if(next[cur][i]==-1){
	next[cur][i]=next[fail[cur]][i];
}
解释就在这里,刚好she这条路径上的下一个节点为-1(即e的下一个节点并不是r),
那么我们就会条到e的fail指针指向的节点上继续匹配，正好he这条路径上有r，
所以我们就匹配了模式串her了，是不是很巧妙，我也觉得很巧妙。
接着的h,s都找不到对应的模式串的，匹配结束，那么res为3,匹配串分别是she,he,her.

匹配的过程有两种:
(1)当前字符匹配，表示从当前节点沿着树边有一条路径可以到达目标字符，此时只需沿该
路径走向下一个节点继续匹配即可，目标字符串指针移向下个字符继续匹配；(2)当前字符
不匹配，则去当前节点失败指针所指向的字符继续匹配，匹配过程随着指针指向root结束。
重复这2个过程中的任意一个，直到模式串走到结尾为止。
```
```
大概ac自动机入门就是这样子啦，如果有错的地方，希望大家提出来，一定会改的。
```

