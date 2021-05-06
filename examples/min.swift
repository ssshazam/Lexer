
func get_min(arr: [Int]) -> Int {
	var min = arr[0]

	for item in arr {
		if item < min {
			min = item
		}
	}
	return min;
}


var min = get_min(arr: [1, 5, 0, -10, 20, 12, -645])

print(min)