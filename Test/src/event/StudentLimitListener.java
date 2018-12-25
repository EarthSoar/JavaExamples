package student;

import java.util.EventListener;

public interface StudentLimitListener extends EventListener{
	void limit(StudentLimitEvent e);
}
