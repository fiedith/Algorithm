# p.316 무지의 먹방 라이브
# https://school.programmers.co.kr/learn/courses/30/lessons/42891

def solution(food_times, k):
    
    answer = 0
    
    for i in range(0, k):
        answer = i
        
        # table cycle
        if i >= len(food_times):
            answer -= len(food_times)
            
        # skip empty plate
        if food_times[answer] == 0:
            continue
        
        # decrement nonempty plate
        food_times[answer] -= 1
        
    # if all empty, return -1
    if all(time == 0 for time in food_times):
        answer = -1
    
    return answer