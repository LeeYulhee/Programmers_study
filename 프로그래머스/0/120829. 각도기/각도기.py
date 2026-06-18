def solution(angle):
    if angle == 180:
        angle = 4
    elif angle > 90:
        angle = 3
    elif angle == 90:
        angle = 2
    else:
        angle = 1
    return angle