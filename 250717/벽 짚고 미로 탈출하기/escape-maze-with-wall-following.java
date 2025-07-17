import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt()-1;
        int y = sc.nextInt()-1;
        char[][] maze = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j);
            }
        }

        boolean[][] visited = new boolean[n][n];
        // Please write your code here.

        // R이라면 i+1 j , U 
        char[] dir = {'R', 'U', 'L', 'D'};
        int curDirIdx = 0;
        int curDir = dir[curDirIdx % 4];

        int cnt = 0;

        outer: while (true) {
            if (visited[x][y]) {
                System.out.print(-1);
                return;
            }
            visited[x][y] = true;
            
            if (curDir == 'R') {
                if (x+1 < n && maze[x+1][y] == '#') {
                    int nx = x;
                    int ny = y+1;

                    if (ny >= n) {
                        System.out.print(cnt + 1);
                        return;
                    }

                    if (maze[nx][ny] == '#') {
                        for (int i = 1; i < 4; i++) {
                        if (dir[(curDirIdx + i) % 4] == 'R') {
                            if (x+1 < n && maze[x+1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'U') {
                            if (y+1 < n && maze[x][y+1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'L') {
                            if (x-1 >= 0 && maze[x-1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'D') {
                            if (y-1 >= 0 && maze[x][y-1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        }
                    }
                        System.out.print(-1);
                        return;
                    }

                    if (maze[nx+1][ny] == '#') {
                        if (!visited[nx][ny]) {
                            x = nx;
                            y = ny;
                            cnt++;
                        } else {
                            System.out.print(-1);
                            return;
                        }
                    } else {
                        if (!visited[nx+1][ny]) {
                            x = nx + 1;
                            y = ny;
                            curDir = 'D';
                            cnt += 2;
                        } else {
                            System.out.print(-1);
                            return;
                        }
                    }
                } else {
                    for (int i = 1; i < 4; i++) {
                        if (dir[(curDirIdx + i) % 4] == 'R') {
                            if (x+1 < n && maze[x+1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'U') {
                            if (y+1 < n && maze[x][y+1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'L') {
                            if (x-1 >= 0 && maze[x-1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'D') {
                            if (y-1 >= 0 && maze[x][y-1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        }
                    }
                    System.out.print(-1);
                    return;
                }
            } else if (curDir == 'U') {
                if (y+1 < n && maze[x][y+1] == '#') {
                    int nx = x-1;
                    int ny = y;

                    if (nx < 0) {
                        System.out.print(cnt + 1);
                        return;
                    }

                    if (maze[nx][ny] == '#') {
                        for (int i = 1; i < 4; i++) {
                        if (dir[(curDirIdx + i) % 4] == 'R') {
                            if (x+1 < n && maze[x+1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'U') {
                            if (y+1 < n && maze[x][y+1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'L') {
                            if (x-1 >= 0 && maze[x-1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'D') {
                            if (y-1 >= 0 && maze[x][y-1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        }
                    }
                        System.out.print(-1);
                        return;
                    }

                    if (maze[nx][ny+1] == '#') {
                        if (!visited[nx][ny]) {
                            x = nx;
                            y = ny;
                            cnt++;
                        } else {
                            System.out.print(-1);
                            return;
                        }
                    } else {
                        if (!visited[nx][ny+1]) {
                            x = nx;
                            y = ny + 1;
                            curDir = 'R';
                            cnt += 2;
                        } else {
                            System.out.print(-1);
                            return;
                        }
                    }
                } else {
                    for (int i = 1; i < 4; i++) {
                        if (dir[(curDirIdx + i) % 4] == 'R') {
                            if (x+1 < n && maze[x+1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'U') {
                            if (y+1 < n && maze[x][y+1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'L') {
                            if (x-1 >= 0 && maze[x-1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'D') {
                            if (y-1 >= 0 && maze[x][y-1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        }
                    }
                    System.out.print(-1);
                    return;
                }
                
            } else if (curDir == 'L') {
                if (x-1 >= 0 && maze[x-1][y] == '#') {
                    int nx = x;
                    int ny = y-1;

                    if (ny < 0) {
                        System.out.print(cnt + 1);
                        return;
                    }

                    if (maze[nx][ny] == '#') {
                        for (int i = 1; i < 4; i++) {
                        if (dir[(curDirIdx + i) % 4] == 'R') {
                            if (x+1 < n && maze[x+1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'U') {
                            if (y+1 < n && maze[x][y+1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'L') {
                            if (x-1 >= 0 && maze[x-1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'D') {
                            if (y-1 >= 0 && maze[x][y-1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        }
                    }
                        System.out.print(-1);
                        return;
                    }

                    if (maze[nx-1][ny] == '#') {
                        if (!visited[nx][ny]) {
                            x = nx;
                            y = ny;
                            cnt++;
                        } else {
                            System.out.print(-1);
                            return;
                        }
                    } else {
                        if (!visited[nx-1][ny]) {
                            x = nx - 1;
                            y = ny;
                            curDir = 'U';
                            cnt += 2;
                        } else {
                            System.out.print(-1);
                            return;
                        }
                    }
                } else {
                    for (int i = 1; i < 4; i++) {
                        if (dir[(curDirIdx + i) % 4] == 'R') {
                            if (x+1 < n && maze[x+1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'U') {
                            if (y+1 < n && maze[x][y+1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'L') {
                            if (x-1 >= 0 && maze[x-1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'D') {
                            if (y-1 >= 0 && maze[x][y-1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        }
                    }
                    System.out.print(-1);
                    return;
                }

            } else if (curDir == 'D') {
                if (y-1 >= 0 && maze[x][y-1] == '#') {
                    int nx = x+1;
                    int ny = y;

                    if (nx >= n) {
                        System.out.print(cnt + 1);
                        return;
                    }

                    if (maze[nx][ny] == '#') {
                        for (int i = 1; i < 4; i++) {
                        if (dir[(curDirIdx + i) % 4] == 'R') {
                            if (x+1 < n && maze[x+1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'U') {
                            if (y+1 < n && maze[x][y+1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'L') {
                            if (x-1 >= 0 && maze[x-1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'D') {
                            if (y-1 >= 0 && maze[x][y-1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        }
                    }
                        System.out.print(-1);
                        return;
                    }

                    if (maze[nx][ny-1] == '#') {
                        if (!visited[nx][ny]) {
                            x = nx;
                            y = ny;
                            cnt++;
                        } else {
                            System.out.print(-1);
                            return;
                        }
                    } else {
                        if (!visited[nx][ny-1]) {
                            x = nx;
                            y = ny-1;
                            curDir = 'L';
                            cnt += 2;
                        } else {
                            System.out.print(-1);
                            return;
                        }
                    }
                } else {
                    for (int i = 1; i < 4; i++) {
                        if (dir[(curDirIdx + i) % 4] == 'R') {
                            if (x+1 < n && maze[x+1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'U') {
                            if (y+1 < n && maze[x][y+1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'L') {
                            if (x-1 >= 0 && maze[x-1][y] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        } else if (dir[(curDirIdx + i) % 4] == 'D') {
                            if (y-1 >= 0 && maze[x][y-1] == '#') {
                                curDir = dir[(curDirIdx + i) % 4];
                                continue outer;
                            }
                        }
                    }
                    System.out.print(-1);
                    return;
                }
                
            }
        }
    }
}


// 현재방향기준 이동하려는 곳의 오른쪽에 벽이 있다면, 그 곳으로 이동한다.
// 벽이 없다면, 이동하고 오른쪽에 벽이 있을 때까지 방향을 바꾼다. (R U L D) +1 하고 %4 으로 인덱스 구하기
// 만약 벽이 있다면 방향 전환을 멈추고 이동한다. 
// 탈출하려면 현재 위치에 벽이 있어야 한다. 현재 방향기준 오른쪽에 벽이 있고, 앞이 인덱스를 벗어난다면, 탈출한다. (return cnt)