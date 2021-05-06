
var a = 30
var b = 18

while a != 0, b != 0 {
	if a > b {
		a -= b
	} else {
		b -= a
	}
}

print(a + b)