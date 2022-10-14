## Spring Bean Scopes and Lifecycle
1. **What is Bean Scopes?**
- Refer to lifecycles of bean
  - How long does bean live?
  - How many instances are created
  - How is the bean shared?

2. **What is a Singleton?**
   - It is cached in memory
   - by default, Spring container created 1 instances of the bean only
   - all request of bean will shared reference to same bean


3. **Type of Spring bean scopes**
   <table>
    <tr>
        <th>Scope</th>
        <th>Description</th>
    </tr>
    <tr>
        <td>singleton</td>
        <td>Create single shared instance of the bean. Default Scope</td>
    </tr>
    <tr>
        <td>prototype</td>
        <td>Creates a new bean instance for each container request.</td>
    </tr>
   </table>
   
4. **How to create scope?**
   ``` 
   < beans...>
        < bean id="myCoach"
                class="com.luv2code.springdemo.TracCoach"
                scope="prototype">
        < /bean>
   < /bean>
   ```
5. **Bean Lifecycle**
   1. Bean Process When Start 
  ``Container Started `` -> ``Bean Instantiated`` -> ``Dependencies Injection`` -> ``Internal Spring Processing`` -> ``Your custom Method`` -> ``Bean Ready to use``
   2. What you can do during Bean initialization
   - calling custom business logic methods
   - Setting up handles to resources (db, sockets, file etc)
   - code example </br>
   ```
   <beans ...>
     <bean id="myCoach"
            class="com.luv2code.springdemo.TrackCoach"
            init-method="doMyStartupStaff">
      ...
      </bean>
   </beans>
   ```
   3. Bean Process When Stop
   ``Container is shutdown`` -> ``Your custom Destroy Method`` -> ``Stop``
   4. What you can do during bean destruction
   - callinng custom business logic methods
   - Clean up handles to resources (db, sockets, file etc)
   - code example</br>
   ```
   <beans ...>
     <bean id="myCoach"
          class="com.luv2code.springdemo.TrackCoach"
          init-method="doMyStartupStuff"
          destroy-method="doMyCleanupStuff">
            ...
     </bean>
   </beans>
   ```
   5. Development process for bean initialization and destruction
   - Define your method for init and destroy
   - Configure method name in Spring config file
   6. About the init and destroy java method
   - Access modifier
     - can have any access modifier
   - Return Type
     - can have any return type, but void mostly used
   - method name
     - can use any method name
   - arguments
     - should be no-args, cannot accept any arguments

