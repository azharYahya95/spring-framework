<h2>Spring Dependency Injection XML configuration</h2>

1) <b>What is Dependency Injection?</b>
   1. Outsource construction and Injection of your object to external entity
   2. We inject Object that ready to use to our class/object
   3. Spring Container will get/prepare object that ready to use for you<br><br>
2) <b>Type of Injection</b>
   1. There are many types of Injection, but in this project will cover 2 types of it
      1. Constructor Injection
      2. Setter Injection
<br><br>
3. <b>Process to do the Dependency Injection</b>
   1. Define dependency Interface and class
   2. Create Constructor in you class for Injection
   3. Configure Dependency Injection in Spring config file
        1. using (<constructor-arg ref="id_class_to_inject"/>)
<br><br>
4. <b>What happened behind the scene of Dependency Injection</b>
   1. When create bean in conf file, behind the scene, Spring will create constructor for you
      1. <p>In conf file</p> <pre><code>< bean id="myFortuneService"
          class="org.example.HappyFortuneService"></bean></code></pre>
                <p>Behind the Scene</p> 
                <pre><code>
            HappyFortuneService myFortuneService = new HappyFortuneService();
         </code></pre>
        
        2. <p>In conf file</p> <pre><code>< bean id="myCoach"class="org.example.BaseballCoach">< constructor-arg ref="id_class_to_inject" /> </ bean> </code></pre>
                <p>Behind the Scene</p> 
                <pre><code>
            BaseballCoach myCoach = new BaseballCoac(myFortuneService);
      </code></pre>
<br><br>
5. <b>Step By Step to do the Setter Injection<b/><br>
   1. Create Setter method in your class for Injections.
        <pre><code>public class CricketCoach{
            private FortuneService fortuneService;
            
            public void setFortuneService(){
                this.fortuneService = fortuneService;
            }
      }</code></pre>
   2. Configure the Dependency Injection in Spring Config file.
      <pre><code> < bean id="myFortuneService" 
                class="HappyFortuneService">< /bean>

      < bean id="myCricketCoach" class="CricketCoach">
          < property name="fortuneService" ref="myFortuneService"/>
      < /bean>
      </code></pre></code></pre>
<br>    
6. <b>Behind The Scene of Setter Injection</b> </br>
- in Config file
    <pre>
<code>< property name="fortuneService" ref="myFortuneService"/></code>
    </pre>
- behind the scene
<pre><code>CricketCoach myCoach = new CricketCoach()
myCoach.setFortuneService(service)</code></pre>

<br>
7. </b><b>Injecting literal values</b><br>
<pre><code>< property name="team" value="Perak FC"/ ></code></pre>

8. <b>Step by Step Injecting values from Properties file</b><br>
   1. Create Properties file
   <br><p>name file: </p><i>sport.properties</i>
       <pre><code>foo.team=FSM</code></pre>
   2. Load Properties file in Spring config file
   <pre><code>< context:property-placeholder location:"classpath:sport.properties"/ ></code></pre>
   3. Reference values from Properties file
    <pre><code>< property name="team" value="${foo.email}" / ></code></pre>
  
