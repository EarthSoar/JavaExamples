package annotation;

import java.lang.annotation.Annotation;

@AnnotationTest(id = 1,name = "na")
class Test{
	public static void main(String[] args) throws Exception {
		//�ж�Test(��Ԫ��)�Ƿ�Ӧ�������ע��
		boolean hasAnnotation = Test.class.isAnnotationPresent(AnnotationTest.class);
		if(hasAnnotation){
			//��ȡע�����
			AnnotationTest t = Test.class.getAnnotation(AnnotationTest.class);
			System.out.println(t.name());
			System.out.println(t.id());
			//��ȡ���е�ע��s
			Annotation[] ans = Test.class.getAnnotations();
			for (Annotation an : ans) {
				System.out.println(an);
			}
		}
		
		System.out.println("============");
		//��ȡ�������ϵ�ע��
		boolean has = Test.class.getMethod("work").isAnnotationPresent(AnnotationTest.class);
		if(has){
			AnnotationTest an = Test.class.getMethod("work").getAnnotation(AnnotationTest.class);
			System.out.println(an.name());
		}
	}
	
	@AnnotationTest(id = 0,name="hello")
	public void work(){
	}
}