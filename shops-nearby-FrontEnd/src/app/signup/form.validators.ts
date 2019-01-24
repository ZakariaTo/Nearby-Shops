import { AbstractControl, ValidationErrors } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import {map} from 'rxjs/operators'

export class FormValidators{

    static isunique(auth :AuthService) {

        return (control: AbstractControl)=>{
            return auth.validateUsername(control.value).pipe(
                map(response =>{
                    return response ?  {usernameTaken: true } : null;
                })
                )
            };
        }
    static matchPasswod(control : AbstractControl){
        let pass1 = control.root.get('password.originalPassword');
        if (pass1) pass1 = pass1.value;
        let pass2 = control.value;

        if (pass1 && pass2 && pass1 !== pass2)
            return { invalidConfirmPassword: true };
            
        return null;
    } 
    
}