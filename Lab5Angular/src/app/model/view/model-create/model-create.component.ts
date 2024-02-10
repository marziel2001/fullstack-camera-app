import {Component, OnInit} from '@angular/core';
import {ModelService} from "../../service/model.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ModelForm} from "../../model/model-form";

@Component({
  selector: 'app-model-create',
  templateUrl: './model-create.component.html',
  styleUrls: ['./model-create.component.css', '../../../forms.css']
})
export class ModelCreateComponent implements OnInit {

  model: ModelForm = {
    name: '',
    price: 0,
    announceYear: 0,
    brand: ''
  }

  constructor(
      private modelService: ModelService,
      private route: ActivatedRoute,
      private router: Router
  ) {
  }
  ngOnInit(): void {
  }

  onSubmit(): void {
    this.route.params.subscribe(params => {
      this.model.brand = params['brandsUuid'];

      this.modelService.putModel(this.model!)
          .subscribe(() => this.router.navigate(['/brands/'+params['brandsUuid']]))
    })
  }
}

