# recursive DP (aka top down)

d = [0] * 100

def fib(x):
    print(str(x) + " called")

    if x == 1 or x == 2:
        return 1
    
    # if corresponding problem is solved and saved into list, return that value
    if d[x] != 0:
        return d[x]
    
    # if not solved, solve and save into list
    d[x] = fib(x - 1) + fib(x - 2)

    return d[x]

print(fib(10))