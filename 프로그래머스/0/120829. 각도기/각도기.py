def solution(angle):
    return [angle > 0, angle >= 90, angle > 90, angle == 180].count(True)