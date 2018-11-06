package annotation;

import java.lang.annotation.Annotation;

@AnnotationTest(id = 1,name = "na")
class Test{
	public static void main(String[] args) throws Exception {
		//判断Test(类元素)是否应用了这个注解
		boolean hasAnnotation = Test.class.isAnnotationPresent(AnnotationTest.class);
		if(hasAnnotation){
			//获取注解对象
			AnnotationTest t = Test.class.getAnnotation(AnnotationTest.class);
			System.out.println(t.name());
			System.out.println(t.id());
			//获取所有的注解s
			Annotation[] ans = Test.class.getAnnotations();
			for (Annotation an : ans) {
				System.out.println(an);
			}
		}
		
		System.out.println("============");
		//获取方法中上的注解
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