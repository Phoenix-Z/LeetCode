# (86ms)
class LogSystem(object):

    def __init__(self):
        self.logs = {}
        self.granularity = {"Year": 0, "Month": 1, "Day": 2, "Hour": 3, "Minute": 4, "Second": 5}

    def put(self, id, timestamp):
        """
        :type id: int
        :type timestamp: str
        :rtype: void
        """
        self.logs[id] = timestamp

    def retrieve(self, s, e, gra):
        """
        :type s: str
        :type e: str
        :type gra: str
        :rtype: List[int]
        """
        def changeBound(origin, gra, isEnd):
            parts = origin.split(':')
            for i in xrange(self.granularity[gra] + 1, 6):
                parts[i] = '00'
            if isEnd:
                val = int(parts[self.granularity[gra]]) + 1
                if val < 10:
                    parts[self.granularity[gra]] = '0' + str(val)
                else:
                    parts[self.granularity[gra]] = str(val)
            return ':'.join(parts)
        s, e = changeBound(s, gra, False), changeBound(e, gra, True)
        return [key for key, value in self.logs.items() if s <= value < e]

obj = LogSystem()
obj.put(1, "2017:01:01:23:59:59")
obj.put(2, "2017:01:01:22:59:59")
obj.put(3, "2016:01:01:00:00:00")
print obj.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year")
print obj.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour")