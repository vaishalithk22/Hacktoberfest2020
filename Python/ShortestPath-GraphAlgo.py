#!/usr/bin/env python3

from collections import deque


def shortestReach(n, edges, s):
    INF = float('Inf')

    graph = [[INF]*(n+1) for var in range(n+1)]
    for u, v, cost in edges:
        graph[u][v] = min(graph[u][v], cost)
        graph[v][u] = graph[u][v]

    distances = [INF]*(n+1)
    distances[s] = 0

    queue = deque()
    queue.append(s)
    while queue:
        node = queue.popleft()
        for v in range(n+1):
            cost = graph[node][v]
            if cost != INF:
                if distances[node] + cost < distances[v]:
                    distances[v] = distances[node] + cost
                    queue.append(v)

    result = []
    for d in distances[1:]:
        if d not in (INF, 0):
            result.append(d)
        elif d == INF:
            result.append(-1)

    return ' '.join(map(str, result))


t = int(input())
for dig in range(t):
    n, m = map(int, input().split())
    edges = set()
    for dig2 in range(m):
        edges.add(tuple(map(int, input().strip().split())))
    s = int(input())
    result = shortestReach(n, edges, s)
    print(result)