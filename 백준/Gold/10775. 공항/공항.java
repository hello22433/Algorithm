
import java.util.*;

public class Main {

    static class UnionFind {
        int[] parent;

        public UnionFind(int G) {
            parent = new int[G + 1];
            for (int i = 1; i <= G; i++) {
                parent[i] = i;
            }
        }

        public int find(int x){
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int G = sc.nextInt();
        int P = sc.nextInt();

        UnionFind uf = new UnionFind(G);

        int count = 0;

        for (int i = 0; i < P; i++) {
            int gi = sc.nextInt();

            int availableGate = uf.find(gi);

            if (availableGate == 0) {
                break;
            }

            uf.union(availableGate, availableGate -1 );
            count++;
        }

        System.out.println(count);
    }
}


// 게이트수 G
// 비행기수 P
// P개의 줄에 도킹하려는 게이트 gi
// gi번째까지 비어있는 곳에 도킹할 것이다.
// 가장 먼 곳부터 배치시켜야 한다.
// 배열을 만든다.
// P만큼 돌리면서 i를 배열에 넣는다.
// 다만, 넣을때 조건이 있다.
// 가장 먼 곳부터 넣어야 한다는 것이다.
// 앞에것부터 처리해야 함.
// 해당 값이 없다면 더 작은 값을 탐색해야 한다.
// set에 G부터 1까지 모든 값을 하나씩 넣고 삭제한다.
// 삭제하려는 해당 값이 없다면
// (다음 인덱스가 마지막이면 마지막줄로 넘어감)다음 인덱스를 삭제한다.
// 삭제할때마다 count += 1;
// 더 작은 값이 없다면 count를 출력한다
//
// unionFind함수를 만든다.
//