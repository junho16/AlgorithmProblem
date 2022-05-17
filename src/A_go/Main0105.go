package main

import "math"

func oneEditAway(first string, second string) bool {
	dis := len(first) - len(second)
	if math.Abs(float64(dis)) >= 2 {
		return false
	}
	if math.Abs(float64(dis)) == 1 {
		//保证first是较长的一个
		if len(first) < len(second) {
			tmp := first
			first = second
			second = tmp
		}
		for i := 0; i < len(second); i++ {
			if first[i] != second[i] {
				s1 := first[0:i] + first[i+1:len(first)]
				if s1 == second {
					return true
				} else {
					return false
				}
			}
		}
		return true
	}
	if len(first) == len(second) {
		num := 0
		for i := 0; i < len(first); i++ {
			if first[i] != second[i] {
				num++
				if num > 1 {
					return false
				}
			}
		}
		return true
	}
	return true
}
