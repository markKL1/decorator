
def get_price():
	return 42

def with_excess(excess, price_fun):
	def decorated_with_excess(*args, **kwargs):
		return max(price_fun(*args, **kwargs) - excess, 0)
	return decorated_with_excess


def with_franchise(franchise, price_fun):
	def decorated_with_franchise(*args, **kwargs):
		price = price_fun(*args, **kwargs)
		return 0 if price < franchise else price
	return decorated_with_franchise

decorated_get_price = with_franchise(25, with_excess(15, get_price))
print(decorated_get_price())


